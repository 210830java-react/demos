import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import Pokemon from "../models/pokemon";

export type PokemonState = Pokemon[];

const initialState: PokemonState = [];

const pokemonSlice = createSlice({
  name: 'pokemon',
  initialState,
  reducers: {
    add: (state, action: PayloadAction<Pokemon>) => {
      state.push(action.payload);
    },
    remove: (state, action: PayloadAction<Number>) => {
      // Remove 1 element at the index where the pokemon id matches the payload id
      state.splice(state.findIndex( (poke => poke.id === action.payload)), 1);
    }
  }
});

export const { add, remove } = pokemonSlice.actions;

export default pokemonSlice.reducer;