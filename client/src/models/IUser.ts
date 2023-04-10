import { ITicket } from "./ITicket"

export interface IUser {
  name: string
  isLoading: boolean
  error: string
  email: string
  tickets: ITicket[]
  //isLoggedIn: boolean
}
