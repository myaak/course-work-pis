import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from '@reduxjs/toolkit'
import { IFilm } from "../../models/IFilm";
import { fetchFilms } from "../ActionCreators/FilmsAction";

interface FilmsList {
  films: IFilm[]
  isLoading: boolean
  error: string | null
}

const filmItem = {
  title: 'Крутые крысы',
  genres: ['Ekshn', 'Fantastica'],
  seanses: ['Today 11.30']
} satisfies IFilm

const initialState: FilmsList = {
  films: [filmItem],
  isLoading: false,
  error: null

}

export const filmsListSlice = createSlice({
  name: 'filmsList',
  initialState,
  reducers: {
  },
  extraReducers: (builder) => {
    //getFilms
    builder.addCase(fetchFilms.fulfilled.type, (state, action: PayloadAction<IFilm[]>) => {
      state.films = [...state.films, ...action.payload]
    }),
      builder.addCase(fetchFilms.pending.type, (state) => {
        state.isLoading = true
      }),
      builder.addCase(fetchFilms.rejected.type, (state, action: PayloadAction<string>) => {
        state.error = action.payload
      })
  }
})


export default filmsListSlice.reducer
