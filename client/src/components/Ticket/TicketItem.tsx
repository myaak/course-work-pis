import { ITicket } from "../../models/ITicket"

export default function TicketItem({id, film, time, place, price}: ITicket) {
  return (
    <div className="ticket-item__container">
      <div className="ticket-item__content">
        <h2 className="ticket-item__title">{film}</h2>
      </div>
    </div>
  )
}

// TODO: макет для билета
