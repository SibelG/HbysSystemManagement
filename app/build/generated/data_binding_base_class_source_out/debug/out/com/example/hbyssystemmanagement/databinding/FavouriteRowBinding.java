// Generated by view binder compiler. Do not edit!
package com.example.hbyssystemmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hbyssystemmanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FavouriteRowBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView deleteView;

  @NonNull
  public final TextView doctorNameFav;

  @NonNull
  public final ImageView imgDoctor;

  @NonNull
  public final TextView txtSection;

  @NonNull
  public final LinearLayoutCompat viewForeground;

  private FavouriteRowBinding(@NonNull CardView rootView, @NonNull ImageView deleteView,
      @NonNull TextView doctorNameFav, @NonNull ImageView imgDoctor, @NonNull TextView txtSection,
      @NonNull LinearLayoutCompat viewForeground) {
    this.rootView = rootView;
    this.deleteView = deleteView;
    this.doctorNameFav = doctorNameFav;
    this.imgDoctor = imgDoctor;
    this.txtSection = txtSection;
    this.viewForeground = viewForeground;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static FavouriteRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FavouriteRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.favourite_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FavouriteRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delete_view;
      ImageView deleteView = ViewBindings.findChildViewById(rootView, id);
      if (deleteView == null) {
        break missingId;
      }

      id = R.id.doctorNameFav;
      TextView doctorNameFav = ViewBindings.findChildViewById(rootView, id);
      if (doctorNameFav == null) {
        break missingId;
      }

      id = R.id.img_doctor;
      ImageView imgDoctor = ViewBindings.findChildViewById(rootView, id);
      if (imgDoctor == null) {
        break missingId;
      }

      id = R.id.txt_section;
      TextView txtSection = ViewBindings.findChildViewById(rootView, id);
      if (txtSection == null) {
        break missingId;
      }

      id = R.id.view_foreground;
      LinearLayoutCompat viewForeground = ViewBindings.findChildViewById(rootView, id);
      if (viewForeground == null) {
        break missingId;
      }

      return new FavouriteRowBinding((CardView) rootView, deleteView, doctorNameFav, imgDoctor,
          txtSection, viewForeground);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
