// Generated by view binder compiler. Do not edit!
package com.example.hbyssystemmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hbyssystemmanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FavDoctorItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView btnShareFav;

  @NonNull
  public final Button button;

  @NonNull
  public final ImageView favButtonFav;

  @NonNull
  public final LinearLayout favLayout;

  @NonNull
  public final RelativeLayout favRelativeLayout;

  @NonNull
  public final ImageView imageViewProductFav;

  @NonNull
  public final TextView productNameFav;

  private FavDoctorItemBinding(@NonNull LinearLayout rootView, @NonNull ImageView btnShareFav,
      @NonNull Button button, @NonNull ImageView favButtonFav, @NonNull LinearLayout favLayout,
      @NonNull RelativeLayout favRelativeLayout, @NonNull ImageView imageViewProductFav,
      @NonNull TextView productNameFav) {
    this.rootView = rootView;
    this.btnShareFav = btnShareFav;
    this.button = button;
    this.favButtonFav = favButtonFav;
    this.favLayout = favLayout;
    this.favRelativeLayout = favRelativeLayout;
    this.imageViewProductFav = imageViewProductFav;
    this.productNameFav = productNameFav;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FavDoctorItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FavDoctorItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fav_doctor_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FavDoctorItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnShareFav;
      ImageView btnShareFav = ViewBindings.findChildViewById(rootView, id);
      if (btnShareFav == null) {
        break missingId;
      }

      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.favButtonFav;
      ImageView favButtonFav = ViewBindings.findChildViewById(rootView, id);
      if (favButtonFav == null) {
        break missingId;
      }

      LinearLayout favLayout = (LinearLayout) rootView;

      id = R.id.favRelativeLayout;
      RelativeLayout favRelativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (favRelativeLayout == null) {
        break missingId;
      }

      id = R.id.imageViewProductFav;
      ImageView imageViewProductFav = ViewBindings.findChildViewById(rootView, id);
      if (imageViewProductFav == null) {
        break missingId;
      }

      id = R.id.productNameFav;
      TextView productNameFav = ViewBindings.findChildViewById(rootView, id);
      if (productNameFav == null) {
        break missingId;
      }

      return new FavDoctorItemBinding((LinearLayout) rootView, btnShareFav, button, favButtonFav,
          favLayout, favRelativeLayout, imageViewProductFav, productNameFav);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
