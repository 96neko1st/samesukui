package SameLib;

import java.util.HashMap;


//
// State Machine
//
public class StateMachine<T> {

    // State
    public class State {
        public T label;
        public Event onStart;
        public Event onStop;
        public Event onUpdate;

        State(T label, Event start, Event stop, Event update) {
            this.label = label;
            this.onStart = start;
            this.onStop = stop;
            this.onUpdate = update;
        }
    }

    HashMap<T, State> states;
    State curState = null;

    StateMachine() {
        states = new HashMap<T, State>();
    }

    public void setStartState(T label) {
        curState = states.get(label);
    }

    public void addState(State state) {
    }

    public void setState(T label) {
        setState(label, null);
    }

    public void setState(T label, EventParam param) {
        State nextstate = states.get(label);

        if (curState == null || nextstate == null)
            return;

        if (curState.onStop != null) {
            curState.onStop.handleEvent(param);
        }

        if (nextstate.onStart != null) {
            nextstate.onStart.handleEvent(param);
        }

        curState = nextstate;
    }

    public void update() {
        if (curState.onUpdate != null) {
            curState.onUpdate.handleEvent(null);
        }
    }
}