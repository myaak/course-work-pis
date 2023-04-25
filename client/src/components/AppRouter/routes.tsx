import { RouteObject } from 'react-router-dom'
import { MY_TICKETS_ROUTE, PROFILE_ROUTE, PROKAT_ROUTE, SEANSI_ROUTE } from './utils/consts'
import Prokat from '../Prokat/Prokat'
import TicketList from '../Ticket/TicketList'


export const MainRoutes: RouteObject[] = [
  {
    path: PROKAT_ROUTE,
    element: <Prokat />
  },
  {
    path: MY_TICKETS_ROUTE,
    element: <TicketList />
  }
]
