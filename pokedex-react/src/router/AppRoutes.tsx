import React from 'react';
import { Redirect, Route, Switch } from 'react-router';
import HomePage from '../components/home-page/HomePage';
import Pokedex from '../components/pokedex/Pokedex';

const AppRoutes: React.FC<unknown> = () => {

  return (
    <>
      <Switch>
          <Route exact path='/pokedex'>
            <Pokedex />
          </Route>
          <Route exact path='/'>
            <HomePage />
          </Route>
          <Route path='/'>
            <Redirect to='/' />
          </Route>
      </Switch>
    </>
  );
}

export default AppRoutes;