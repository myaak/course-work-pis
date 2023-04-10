import { configureStore } from '@reduxjs/toolkit'
import filmsListSlice from './reducers/filmsList'
import userReducer from './reducers/userReducer'

export const store = configureStore({
  reducer: {
    filmsList: filmsListSlice,
    user: userReducer
  }
})





export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
