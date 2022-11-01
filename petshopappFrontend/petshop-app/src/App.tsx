
import './App.css';
import MainRoutes from './MainRoutes';
import { Footer } from './MyComponents/Footer';
import Navbar from './MyComponents/Navbar';

function App() {

  return (
    <div>
      
      <Navbar></Navbar> 
      <MainRoutes></MainRoutes>
      <Footer></Footer>  
         
    </div>
  );
}

export default App;
