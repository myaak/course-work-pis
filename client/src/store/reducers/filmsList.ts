import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from '@reduxjs/toolkit'

interface FilmsList {
  films: Array<FilmObject>
}

export interface FilmObject {
  filmName: string
  filmGenres: Array<string>
  filmSeanes: Array<string>
}

const filmItem = {
  filmName: 'Крутые крысы',
  filmGenres: ['Ekshn', 'Fantastica'],
  filmSeanes: ['Today 11.30']
} satisfies FilmObject

const initialState: FilmsList = {
  films: [filmItem]
}

export const filmsListSlice = createSlice({
  name: 'filmsList',
  initialState,
  reducers: {
  },
})


export default filmsListSlice.reducer
