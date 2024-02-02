import './App.css';
import ExerciseList from "./components/ExerciseList";
import {Brand, Navbar} from "./components";
import {Footer, Header} from "./containers";

function App() {
  return (
    <div className="App">

        <div className="gradient__bg">
            <Navbar />
            <Header />
//             <ExerciseList />
        </div>
        <Brand />
        <Footer />
    </div>
  );
}

export default App;
