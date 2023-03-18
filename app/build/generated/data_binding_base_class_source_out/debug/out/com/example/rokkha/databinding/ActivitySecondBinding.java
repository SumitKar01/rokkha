// Generated by view binder compiler. Do not edit!
package com.example.rokkha.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.rokkha.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySecondBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnSignout;

  @NonNull
  public final Button proceedbutton;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView tvUserEmail;

  private ActivitySecondBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnSignout,
      @NonNull Button proceedbutton, @NonNull TextView textView, @NonNull TextView tvUserEmail) {
    this.rootView = rootView;
    this.btnSignout = btnSignout;
    this.proceedbutton = proceedbutton;
    this.textView = textView;
    this.tvUserEmail = tvUserEmail;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySecondBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_second, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySecondBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSignout;
      Button btnSignout = ViewBindings.findChildViewById(rootView, id);
      if (btnSignout == null) {
        break missingId;
      }

      id = R.id.proceedbutton;
      Button proceedbutton = ViewBindings.findChildViewById(rootView, id);
      if (proceedbutton == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.tvUserEmail;
      TextView tvUserEmail = ViewBindings.findChildViewById(rootView, id);
      if (tvUserEmail == null) {
        break missingId;
      }

      return new ActivitySecondBinding((ConstraintLayout) rootView, btnSignout, proceedbutton,
          textView, tvUserEmail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
