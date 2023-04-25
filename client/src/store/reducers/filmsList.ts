import { createSlice } from "@reduxjs/toolkit";
import type { PayloadAction } from '@reduxjs/toolkit'
import { IFilm } from "../../models/IFilm";
import { fetchFilms } from "../ActionCreators/FilmsAction";

interface FilmsList {
  films: IFilm[]
  isLoading: boolean
  error: string | null
}

const initialState: FilmsList = {
  films: [
    {
      cover: "",
      title: "NewFilm",
      genres: ["Фантастика"],
      seanses: ["10:30"]
    }
  ],
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
      state.films = [...action.payload]
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
