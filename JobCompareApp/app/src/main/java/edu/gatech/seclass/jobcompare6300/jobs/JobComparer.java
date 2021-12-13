package edu.gatech.seclass.jobcompare6300.jobs;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;

public class JobComparer {

  private final ArrayList<JobOffer> selectedJobOffers;
  private final ArrayList<JobOffer> allJobOffers;
  private final UserWeights weights;

  public JobComparer(
      UserWeights userWeights,
      ArrayList<JobOffer> allOffers,
      ArrayList<JobOffer> currentlySelected) {
    selectedJobOffers = currentlySelected;
    allJobOffers = allOffers;
    weights = userWeights;
  }

  public void selectJob(int index) {
    selectedJobOffers.add(allJobOffers.get(index));
  }

  public void selectJob(JobOffer toSelect) {
    selectedJobOffers.add(toSelect);
  }

  public void unselectJob(int index) {
    selectedJobOffers.remove(index);
  }

  // could be optimized
  public void unselectJob(JobOffer toBeUnselected) {
    selectedJobOffers.remove(toBeUnselected);
  }

  public List<JobOffer> rankSelectedJobOffers() {
    return Ranker.rank(weights, selectedJobOffers);
  }

  public List<JobOffer> getSelectedOffers() {
    return selectedJobOffers;
  }
}
