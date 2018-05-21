package src;

import Directions.*;

public enum  DirectionsType
{
    N {
       public void move(Scenario scenario)
       {
           North.staticMoveMethod(scenario);
       }
    },

    E {
        public void move(Scenario scenario)
        {
            East.staticMoveMethod(scenario);
        }
    },

    S{
        public void move(Scenario scenario)
        {
            South.staticMoveMethod(scenario);
        }
    },

    W {
        public void move(Scenario scenario)
        {
            West.staticMoveMethod(scenario);
        }
    };

    public abstract void move(Scenario point);
}