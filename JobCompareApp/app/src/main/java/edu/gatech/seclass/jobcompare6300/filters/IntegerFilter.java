package edu.gatech.seclass.jobcompare6300.filters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

import java.util.function.Supplier;

/** Blocks input that is greater than {@code maxValue}. */
public class IntegerFilter implements InputFilter {

  private final int maxValue;
  private final Supplier<Context> context;

  public IntegerFilter(int maxValue, Supplier<Context> context) {
    this.maxValue = maxValue;
    this.context = context;
  }

  @Override
  public CharSequence filter(
      CharSequence source, int start, int end, Spanned dest, int dStart, int dEnd) {
    try {
      String sequence = dest.subSequence(0, dStart).toString();
      int value = 0;
      if (!sequence.isEmpty()) {
        value = Integer.parseInt(
            dest.subSequence(0, dStart).toString()
            + source
            + dest.subSequence(dEnd, dest.length()));
      }
      if (value <= maxValue) {
        return null;
      }
    } catch (NumberFormatException ignored) {
    }
    makeToast();
    return "";
  }

  @SuppressLint("DefaultLocale")
  private void makeToast() {
    Toast.makeText(
        context.get(),
        String.format("Please input at most: %d", maxValue),
        Toast.LENGTH_SHORT).show();
  }
}
