import { createAsyncThunk } from "@reduxjs/toolkit"
import { serverUrl } from "../../info"
import { IFilm } from "../../models/IFilm"
import axios from "axios"


export const fetchFilms = createAsyncThunk(
  'films/getFilms',
  async (_, thinkAPI) => {
    try {
      const response = await axios.get<IFilm[]>(`${serverUrl}/get/movies`)
      return response.data
    } catch (error) {
      return thinkAPI.rejectWithValue("Нет подключения к серверу")
    }
  }
)
