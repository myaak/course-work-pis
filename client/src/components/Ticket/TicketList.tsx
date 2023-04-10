import TIcketItem from './TicketItem'
import { useAppSelector } from "../../app/hooks"

export default function TicketList() {

const { tickets } = useAppSelector(state => state.user)

  return (
    <div className="ticket__list__container">
      {tickets.map((item: any, index: number) => (
      <TIcketItem key={index}/>
      ))}
    </div>
  )
}

// TODO: макет для списка билетов
// еще нужно сделать нормальный фетч когда сервак уже будет
