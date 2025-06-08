export class Message {
  constructor(
   public statusCode: number,
   public datetime: string,
   public message: string,
   public details: string
  ) {}
}