import { configureStore } from '@reduxjs/toolkit'
import filmsListSlice from './reducers/filmsList'

export const store = configureStore({
  reducer: {
    filmsList: filmsListSlice,
  }
})





export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
