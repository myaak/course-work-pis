import { Route, Routes } from "react-router-dom"
import { MainRoutes } from "./routes" 

export default function AppRouter() {
  return (
  <Routes>
      {MainRoutes.map((item: any, index: number) => (
        <Route key={index} path={item.path} element={item.element}/>
      ))
    }
    </Routes>
  )
}
