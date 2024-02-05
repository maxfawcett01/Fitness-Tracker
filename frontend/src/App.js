import './App.css';
import {Brand, Navbar} from "./components";
import {Footer, Header} from "./containers";

function App() {
  return (
    <div className="App">
        <div className="gradient__bg">
            <Navbar />
            <Header />
        </div>
        <Brand />
        <Footer />
          <h1>Fitness Tracker</h1>
            <HealthStatisticList />
    </div>
  );
}

export default App;
