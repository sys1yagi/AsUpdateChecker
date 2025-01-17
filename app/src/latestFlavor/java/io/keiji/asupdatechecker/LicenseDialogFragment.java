package io.keiji.asupdatechecker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LicenseDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    public static LicenseDialogFragment newInstance() {
        return new LicenseDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        StringBuffer license = new StringBuffer();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    getActivity().getAssets().open("licenses/support_libraries.txt")));

            String line = null;
            while ((line = br.readLine()) != null) {
                license.append(line)
                        .append("\n");
            }

        } catch (IOException e) {
        }

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Open Source License")
                .setMessage(license)
                .setPositiveButton(android.R.string.ok, this)
                .create();

        return dialog;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
    }
}
