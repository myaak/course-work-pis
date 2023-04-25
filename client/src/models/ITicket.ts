import { IPlace } from "./IPlace"

export interface ITicket {
  id?: number
  film?: string
  time?: string
  place?: IPlace[]
  price?: number
}
