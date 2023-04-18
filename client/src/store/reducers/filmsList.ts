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
  filmName: 'Крутые крысы',
  filmGenres: ['Ekshn', 'Fantastica'],
  filmSeanes: ['Today 11.30']
} satisfies IFilm

const initialState: FilmsList = {
  films: [filmItem, filmItem,
    filmItem, filmItem, filmItem, filmItem, filmItem, filmItem, filmItem, filmItem, filmItem, filmItem, filmItem, filmItem],
  isLoading: false,
  error: null

}

export const filmsListSlice = createSlice({
  name: 'filmsList',
  initialState,
  reducers: {
  },
  extraReducers: {
    //getFilms
    [fetchFilms.fulfilled.type]: (state, action: PayloadAction<IFilm[]>) => {
      state.films = action.payload
    },
    [fetchFilms.pending.type]: (state) => {
      state.isLoading = true
    },
    [fetchFilms.rejected.type]: (state, action: PayloadAction<string>) => {
      state.error = action.payload
    },
  }
})


export default filmsListSlice.reducer
