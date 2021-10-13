import React, { FormEvent, useEffect, useState } from 'react';
import { getPokemon } from '../../remote/poke-api/poke.api';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap';
import { useAppDispatch, useAppSelector } from '../../hooks';
import { add, remove } from '../../slices/pokemon.slice';

const Pokedex: React.FC<unknown> = () => {

  const dispatch = useAppDispatch();
  const pokemonState = useAppSelector( (state) => state.pokemon);

  const [name, setName] = useState("");

  useEffect( () => {
    (async () => {
      try {
        dispatch(add(await getPokemon(59)));
      } catch(error) {
        console.log(error);
      }
    })();
  }, [dispatch]);

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      let poke = await getPokemon(name);
      console.log(poke);
      dispatch(add(poke));
    } catch (error) {
      alert(`Pokemon ${name} not found!`);
      console.log(error);
    }
  };

  const handleRemove = (): void => {
    dispatch(remove(pokemonState[0].id));
  }

  return (
    <div>
      <Form onSubmit={(e) => handleSubmit(e)}>
        <Form.Group className="mb-3">
          <Form.Label>Pokemon Name</Form.Label>
          <Form.Control required type="text" placeholder="arcanine" onChange={(e) => setName(e.target.value)}/>
        </Form.Group>
        <Button variant="primary" type="submit">
          Search for Pokemon
        </Button>
        <Button variant="secondary" onClick={() => handleRemove()}>
          Remove Pokemon
        </Button>
      </Form>
      {
        pokemonState.map( pokemon => (
          <>
            <br />
            <p>
              id: {pokemon.id} <br/>
              name: {pokemon.name} <br/>
              height: {pokemon.height} <br/>
              weight: {pokemon.weight} <br/>
            </p>
          </>
        ))
      }
    </div>
  );
}

export default Pokedex;
