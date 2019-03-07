package com.danielqueiroz.workout;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielqueiroz.workout.model.Workout;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    public WorkoutDetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null){
            workoutId = savedInstanceState.getLong("workoutId");
        } else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopwacthFragment stopwacthFragment = new StopwacthFragment();
            ft.replace(R.id.stopwatch_container, stopwacthFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            TextView textTitle = (TextView) view.findViewById(R.id.textTitle);
            TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
            Workout workout = Workout.workouts[(int) workoutId];

            textTitle.setText(workout.getName());
            textDescription.setText(workout.getDescription());
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("workoutId",workoutId);
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

}
