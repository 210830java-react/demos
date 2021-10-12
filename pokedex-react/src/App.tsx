/* eslint-disable @typescript-eslint/no-unused-expressions */
import React, { useEffect } from 'react';
import logo from './logo.svg';
import './App.css';
import { getPokemon } from './remote/poke-api/poke.api';

const App: React.FC<unknown> = () => {

  useEffect( () => {
    (async () => {
      console.log(await getPokemon('arcanine'));
    });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
