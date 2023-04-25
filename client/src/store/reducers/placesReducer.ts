import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { IPlace } from "../../models/IPlace";


const initialState = {
  currentPlaces: [] as IPlace[]
}

export const placesSlice = createSlice({
  name: "places",
  initialState,
  reducers: {
    addPlace(state, action: PayloadAction<IPlace>) {
      state.currentPlaces = [...state.currentPlaces, action.payload]
    },
    clearPlaces(state) {
      state.currentPlaces = initialState.currentPlaces
    }
  }
})


export const { addPlace, clearPlaces } = placesSlice.actions
export default placesSlice.reducer
