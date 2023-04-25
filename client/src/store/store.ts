import { configureStore } from '@reduxjs/toolkit'
import filmsListSlice from './reducers/filmsList'
import seanseModal from './reducers/modalReducer'
import placesSlice from './reducers/placesReducer'
import userReducer from './reducers/userReducer'

export const store = configureStore({
  reducer: {
    filmsList: filmsListSlice,
    user: userReducer,
    seanseModal: seanseModal,
    placesSlice: placesSlice
  }
})





export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch
