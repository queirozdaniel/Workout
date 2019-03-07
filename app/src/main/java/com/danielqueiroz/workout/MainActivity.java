package com.danielqueiroz.workout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void intemClicked(long id){
        View fragmentContainer =  findViewById(R.id.fragment_container);
        if (fragmentContainer != null){
            WorkoutDetailFragment detailFragment =  new WorkoutDetailFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            detailFragment.setWorkoutId(id);
            fragmentTransaction.replace(R.id.fragment_container, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }


    }

}
