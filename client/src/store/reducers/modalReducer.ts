import { createSlice, PayloadAction } from '@reduxjs/toolkit'

const initialState = {
  opened: false
}
export const seanseModal = createSlice({
  name: "seanseModal",
  initialState,
  reducers: {
    changeModalState(state, action: PayloadAction<boolean>) {
      state.opened = action.payload
    }
  }
})

export const { changeModalState } = seanseModal.actions
export default seanseModal.reducer
