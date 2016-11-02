package com.hfad.workout;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
    private final static String WORKOUT_ID = "WORKOUT_ID";
    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong(WORKOUT_ID);
        } else {
            // При повороте устройства, все транзакции пвторяются.
            // Это значит что этот фрагмент будет создан с дочерним фрагментом
            // Если мы будем повторять эти действия всегда, то при повороте будет всегда создаваться новый фрагмент
            // Он не сможет восстановить своего прежнего состояния.
            // Получаем дочернюю транзакцию что бы создать вложенную транзакцию,
            // что бы отменялись сразу оба действия. Переход в этот фрагмент и добавление дочернего фрагмента.
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopwatchFragment stopwatchFragment = new StopwatchFragment(); // Создаем фрагмент
            ft.replace(R.id.stopwatch_container, stopwatchFragment); // Создаем действие замены т.е. добавляем фрагмент
            ft.addToBackStack(null); // Идентификатор транзакции не нужен. Мы не будем к ней обращаться
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); // Задем анимацию
            ft.commit(); // Применяем транзакцию
        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.WORKOUTS[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long id) {
        workoutId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong(WORKOUT_ID, workoutId);
        super.onSaveInstanceState(outState);

    }
}
