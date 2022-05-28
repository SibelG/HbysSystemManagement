// Generated by view binder compiler. Do not edit!
package com.example.hbyssystemmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hbyssystemmanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDateBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final TextView dateAvilableDate;

  @NonNull
  public final RecyclerView dateDoctorListRecyclerView;

  @NonNull
  public final LinearLayoutCompat dateFragment;

  @NonNull
  public final TextView dateSelectDate;

  @NonNull
  public final TextView dateSelectedDate;

  private FragmentDateBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull TextView dateAvilableDate, @NonNull RecyclerView dateDoctorListRecyclerView,
      @NonNull LinearLayoutCompat dateFragment, @NonNull TextView dateSelectDate,
      @NonNull TextView dateSelectedDate) {
    this.rootView = rootView;
    this.dateAvilableDate = dateAvilableDate;
    this.dateDoctorListRecyclerView = dateDoctorListRecyclerView;
    this.dateFragment = dateFragment;
    this.dateSelectDate = dateSelectDate;
    this.dateSelectedDate = dateSelectedDate;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_date, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.date_avilableDate;
      TextView dateAvilableDate = ViewBindings.findChildViewById(rootView, id);
      if (dateAvilableDate == null) {
        break missingId;
      }

      id = R.id.date_doctorList_recyclerView;
      RecyclerView dateDoctorListRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (dateDoctorListRecyclerView == null) {
        break missingId;
      }

      LinearLayoutCompat dateFragment = (LinearLayoutCompat) rootView;

      id = R.id.date_select_date;
      TextView dateSelectDate = ViewBindings.findChildViewById(rootView, id);
      if (dateSelectDate == null) {
        break missingId;
      }

      id = R.id.date_selected_date;
      TextView dateSelectedDate = ViewBindings.findChildViewById(rootView, id);
      if (dateSelectedDate == null) {
        break missingId;
      }

      return new FragmentDateBinding((LinearLayoutCompat) rootView, dateAvilableDate,
          dateDoctorListRecyclerView, dateFragment, dateSelectDate, dateSelectedDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
