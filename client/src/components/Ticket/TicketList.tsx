import TicketItem from './TicketItem'
import { useAppSelector } from "../../app/hooks"
import { ITicket } from '../../models/ITicket'

export default function TicketList() {

  const tickets = useAppSelector(state => state.user.tickets)

  return (
    <div className="ticket__list__container">
      {tickets.map((item: ITicket, index: number) => (
        <TicketItem key={index}
          id={item.id}
          film={item.film}
          time={item.time}
          place={item.place}
          price={item.price}
        />
      ))}
    </div>
  )
}

// TODO: макет для списка билетов
// еще нужно сделать нормальный фетч когда сервак уже будет
