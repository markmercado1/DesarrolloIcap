package pe.colegiodeabogados.puno.Icap.service.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pe.colegiodeabogados.puno.Icap.dtos.UsuarioDTO;
import pe.colegiodeabogados.puno.Icap.exception.ModelNotFoundException;
import pe.colegiodeabogados.puno.Icap.mappers.UserAgremiadoMapper;
import pe.colegiodeabogados.puno.Icap.model.Rol;

import pe.colegiodeabogados.puno.Icap.model.Usuario;
import pe.colegiodeabogados.puno.Icap.model.UsuarioRol;
import pe.colegiodeabogados.puno.Icap.repository.ICrudGenericRepository;
import pe.colegiodeabogados.puno.Icap.repository.IUsuarioRepository;
import pe.colegiodeabogados.puno.Icap.service.IRolService;
import pe.colegiodeabogados.puno.Icap.service.IUsuarioRolService;
import pe.colegiodeabogados.puno.Icap.service.IUsuarioService;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CrudGenericoServiceImp<Usuario,Long>
        implements IUsuarioService { private final IUsuarioRepository repo;

    private final IRolService rolService;
    private final IUsuarioRolService iurService;

    //private final PasswordEncoder passwordEncoder; //descomenta al trabajar spring security
    private final UserAgremiadoMapper userMapper;

    @Override
    protected ICrudGenericRepository<Usuario, Long> getRepo() {
        return repo;
    }



    @Override
    public UsuarioDTO login(UsuarioDTO.CredencialesDto credentialsDto) {
        Usuario user = repo.findOneByUser(credentialsDto.user())
                .orElseThrow(() -> new ModelNotFoundException("Unknown user", HttpStatus.NOT_FOUND));
        //descomenta al trabajar spring security
        /*if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.clave()), user.getClave())) {
            return userMapper.toDTO(user);
        }*/

        if (credentialsDto.clave().equals(user.getClave())) {
            return userMapper.toDTO(user);
        }

        throw new ModelNotFoundException("Invalid password", HttpStatus.BAD_REQUEST);
    }



    @Override
    public UsuarioDTO register(UsuarioDTO.UsuarioCrearDto userDto) {
        Optional<Usuario> optionalUser = repo.findOneByUser(userDto.user());
        if (optionalUser.isPresent()) {
            throw new ModelNotFoundException("Login already exists", HttpStatus.BAD_REQUEST);
        }
        Usuario user = userMapper.toEntityFromCADTO(userDto);
        //user.setClave(passwordEncoder.encode(CharBuffer.wrap(userDto.clave()))); //descomenta al trabajar spring security
        user.setClave(userDto.clave().toString());
        Usuario savedUser = repo.save(user);
        Rol r;
        switch (userDto.rol()){
            case "ADMIN":{
                r=rolService.getByNombre(Rol.RolNombre.ADMIN).orElse(null);
            } break;
            case "DBA":{
                r=rolService.getByNombre(Rol.RolNombre.DBA).orElse(null);
            } break;
            default:{
                r=rolService.getByNombre(Rol.RolNombre.USER).orElse(null);
            } break;
        }

        /*UsuarioRol u=new UsuarioRol();
        u.setRol(r);
        u.setUsuario(savedUser);
        iurService.save(u);
        */

        iurService.save(UsuarioRol.builder()
                .usuario(savedUser)
                .rol(r)
                .build());
        return userMapper.toDTO(savedUser);
    }
}
