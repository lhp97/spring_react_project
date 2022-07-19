import Header from "./components/Header/header";
import NotificationButton from "./components/NotificationButton/notificationButton";
import SalesCard from "./components/SalesCard/salesCard";

function App() {
  return (
    <div>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard/>
          </div>
        </section>
      </main>
    </div>
  );
}

export default App;
