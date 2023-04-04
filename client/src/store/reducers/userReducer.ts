import { createSlice } from '@reduxjs/toolkit'
import type { PayloadAction } from '@reduxjs/toolkit'



interface User {
  name: string
  email: string
  //isLoggedIn: boolean
}

const initialState: User = {
  name: '',
  email: ''
} 

export const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    logIn: (state, action: PayloadAction<User>) => {
      state = action.payload
    },
    logOut: (state) => {
      state = initialState
    }
  }
})
