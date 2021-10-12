import React, { FormEvent, useEffect, useState } from 'react';
import { getPokemon } from './remote/poke-api/poke.api';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form, Button } from 'react-bootstrap';

const App: React.FC<unknown> = () => {

  const [name, setName] = useState("");
  const [info, setInfo] = useState({
    id: 0,
    name: "",
    weight: 0,
    height: 0,
  });

  useEffect( () => {
    (async () => {
      try {
        console.log(await getPokemon(59));
      } catch(error) {
        console.log(error);
      }
    })();
  }, []);

  const searchPokemon = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      let p = await getPokemon(name);
      console.log(p);
      setInfo({
        id: p.id,
        name: p.name,
        weight: p.weight,
        height: p.height
      });
    } catch (error) {
      alert(`Pokemon ${name} not found!`);
      console.log(error);
    }
  };

  return (
    <div>
      <Form onSubmit={(e) => searchPokemon(e)}>
        <Form.Group className="mb-3">
          <Form.Label>Pokemon Name</Form.Label>
          <Form.Control required type="text" placeholder="blue eyes white dragon" onChange={(e) => setName(e.target.value)}/>
        </Form.Group>
        <Button variant="primary" type="submit">
          Search for Pokemon
        </Button>
      </Form>
      <br />
      <p>
        id: {info.id} <br/>
        name: {info.name} <br/>
        height: {info.height} <br/>
        weight: {info.weight} <br/>
      </p>
    </div>
  );
}

export default App;
