import React from 'react';
import NavBar from './components/navbar/NavBar';
import AppRoutes from './router/AppRoutes';


const App: React.FC<unknown> = () => {

  return (
    <>
      <NavBar />
      <AppRoutes />
    </>
  );
}

export default App;
