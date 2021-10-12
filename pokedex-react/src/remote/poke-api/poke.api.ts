import Pokemon from '../../models/pokemon';
import pokeClient from './poke.client';

export const getPokemon = async (id: string | number): Promise<Pokemon> => {
    const { data: pokemon } = await pokeClient.get<Pokemon>(`/pokemon/${id}`);

    return pokemon;
}