import { IPlace } from "../../models/IPlace"
import { ITicket } from "../../models/ITicket"

export default function TicketItem({ id, film, time, place, price }: ITicket) {
  return (
    <div className="ticket-item__container">
      <div className="ticket-item__content">
        <h2 className="ticket-item__title">{film}</h2>
        {place?.map((item: IPlace) => (
          <div>{item.number}</div>
          ))
        }
      </div>
    </div>
  )
}

// TODO: макет для билета
