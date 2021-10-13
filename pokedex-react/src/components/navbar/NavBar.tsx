import React from 'react';
import { Button } from 'react-bootstrap';
import { useHistory, NavLink } from 'react-router-dom';

const NavBar: React.FC<unknown> = () => {
  const history = useHistory();

  const someCallback = (): void => {
    // do some logic

    history.push('pokedex');
  }

  return (
    <nav className="navbar navbar-expand-md navbar-light bg-light">
      <div id="nav" className="container-fluid">
        <NavLink className="navbar-brand" to="/">Home</NavLink>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarCollapse">
          <ul className="navbar-nav">
            <li className="nav-item">
              <NavLink className="nav-link" to="/pokedex">Pokedex</NavLink>
            </li>
            {/* <li className="nav-item">
              <NavLink className="nav-link" to="/clicker">Clicker</NavLink>
            </li> */}
          </ul>
          <ul className="navbar-nav ms-auto">
            {/* { !user ? (
              <>
                <li className="nav-item">
                  <NavLink className="nav-link" to="/login">Login</NavLink>
                </li>
                <li className="nav-item">
                  <NavLink className="nav-link" to="/register">Register</NavLink>
                </li>
              </>
              ) : (
              <li className="nav-item">
                <input type='submit' onClick={handleLogout} value='Logout' />
              </li>
              )
            } */}
            <Button onClick={() => someCallback()}>
              Go Home
            </Button>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default NavBar;