import { createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'
import { IUser } from '../../models/IUser'
import { ITicket } from '../../models/ITicket'
import { fetchTickets, logInUser } from '../ActionCreators/UsersAction'


const initialState: IUser = {
  name: '',
  email: '',
  isLoading: false,
  error: '',
  tickets: []
}

export const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    logOut: (state) => {
      state.name = initialState.name
      state.email = initialState.email
      state.isLoading = false
      state.error = ''
      state.tickets = initialState.tickets
    }
  },
  extraReducers: (builder) => {
    //userLogin
    builder.addCase(logInUser.fulfilled.type, (state, action: PayloadAction<IUser>) => {
      state.isLoading = false
      state.error = ''
      state.name = action.payload.name
      state.email = action.payload.email
    }),
      builder.addCase(logInUser.pending.type, (state) => {
        state.isLoading = true
      }),
      builder.addCase(logInUser.rejected.type, (state, action: PayloadAction<string>) => {
        state.error = action.payload
      }),
      //tickets
      builder.addCase(fetchTickets.fulfilled.type, (state, action: PayloadAction<ITicket[]>) => {
        state.isLoading = false
        state.error = ''
        state.tickets = action.payload
      }),
      builder.addCase(fetchTickets.pending.type, (state) => {
        state.isLoading = true
      }),
      builder.addCase(fetchTickets.rejected.type, (state, action: PayloadAction<string>) => {
        state.isLoading = false
        state.error = action.payload
      })
  }
})


export default userSlice.reducer


