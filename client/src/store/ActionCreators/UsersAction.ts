import { createAsyncThunk } from "@reduxjs/toolkit"
import { ITicket } from "../../models/ITicket"
import { IUser } from "../../models/IUser"
import { serverUrl } from "../../info"
import axios from "axios"


export const logInUser = createAsyncThunk(
  'users/login',
  async (_, thinkAPI) => {
    try {
      const response = await axios.get<IUser[]>(`${serverUrl}`)
      return response.data
    } catch (error) {
      return thinkAPI.rejectWithValue("Нет подключения к серверу")
    }
  }
)

export const fetchTickets = createAsyncThunk(
  'users/fetchTickets',
  async (_, thunkAPI) => {
    try {
      const response = await axios.get<ITicket[]>(`${serverUrl}/get/tickets`)
      return response.data
    } catch (error) {
      return thunkAPI.rejectWithValue("Нет подключения к серверу")
    }
  }
)
