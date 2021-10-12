import Pokemon from '../../models/pokemon';
import pokeClient from './poke.client';

export const getPokemon = async (id: string | number): Promise<Pokemon> => {
    const { data: pokemon } = await pokeClient.get<Pokemon>(`/api/Pokemon/${id}`);

    console.log(pokemon);
    console.log('id' in pokemon); // true/false
    // Which is only here as a sanity check in case something goes wrong

    return pokemon;
}