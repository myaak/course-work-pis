import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from '@reduxjs/toolkit'
import { IFilm } from "../../models/IFilm";

interface FilmsList {
  films: IFilm[]
}

const filmItem = {
  filmName: 'Крутые крысы',
  filmGenres: ['Ekshn', 'Fantastica'],
  filmSeanes: ['Today 11.30']
} satisfies IFilm

const initialState: FilmsList = {
  films: [filmItem, filmItem,
filmItem, filmItem,filmItem, filmItem,filmItem, filmItem,filmItem, filmItem,filmItem, filmItem,filmItem, filmItem]
}

export const filmsListSlice = createSlice({
  name: 'filmsList',
  initialState,
  reducers: {
  },
})


export default filmsListSlice.reducer
