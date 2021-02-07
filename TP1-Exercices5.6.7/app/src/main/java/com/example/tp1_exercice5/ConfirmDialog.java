package com.example.tp1_exercice5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Map;

public class ConfirmDialog extends DialogFragment {

    private DataInterface listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Activity currentActivity = (Activity) getActivity();
                        Map<String, String> data = listener.getData();
                        Intent intent = new Intent(currentActivity.getBaseContext(), SecondActivity.class);
                        for(String key : data.keySet()) {
                            intent.putExtra(key, data.get(key));
                        }
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Fermeture automatique...
                    }
                });

        return builder.create();
    }

    // On attache et on détache le listener au dialogue (en fonction de l'activité).
    @Override
    public void onAttach(Activity activity) {
        listener = (DataInterface) activity;
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }

    // Interface pour la récupération des données d'une activité vers un dialogue.
    // Approche basée sur la réutilisation, plutôt que de faire des liens entre activité et dialogue codés en dur.
    public static interface DataInterface {
        public Map<String, String> getData();
    }
}
