import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/dist/query/react'
import { serverUrl } from '../info'
import { ITicket } from '../models/ITicket'

export const ticketsAPI = createApi({
  reducerPath: 'ticketReducer',
  baseQuery: fetchBaseQuery({ baseUrl: serverUrl}),
  endpoints: (build) => ({
    fetchAllTickets: build.query<ITicket[]>({
      query: () => ({
        url: '/tickets'
      })
    })
  }),

})
