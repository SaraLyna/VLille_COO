package projetCOO.control.worker.repairer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projetCOO.twoWheeledVehicle.TwoWheeledVehicle;

public class Planning {

    private Map<Repairer, List<RepairTask>> repairerTasks;

    /**
     * Constructor of the class
     */
    public Planning() {
        this.repairerTasks = new HashMap<>();
    }

    /**
     * Assign a repair task to a specific repairer.
     * @param repairer 
     * @param v
     * @param startDateTime 
     * @param endDateTime   
     */
    public void assignRepairTask(Repairer repairer, TwoWheeledVehicle v, String startDateTime, String endDateTime) {
        RepairTask task = new RepairTask(v, startDateTime, endDateTime);
        repairerTasks.computeIfAbsent(repairer, k -> new java.util.ArrayList<>()).add(task);
    }

    /**
     * Get the repair tasks for a specific repairer.
     * @param repairer 
     * @return The list of repair tasks for the repairer.
     */
    public List<RepairTask> getRepairTasksForRepairer(Repairer repairer) {
        return repairerTasks.getOrDefault(repairer, new java.util.ArrayList<>());
    }

    /**
     * Remove a repair task from a repairer.
     * @param repairer 
     * @param task    
     */
    public void removeRepairTask(Repairer repairer, RepairTask task) {
        List<RepairTask> tasks = repairerTasks.get(repairer);
        if (tasks != null) {
            tasks.remove(task);
        }
    }

    /**
     * Clear the entire planning.
     */
    public void clearPlanning() {
        repairerTasks.clear();
    }

    /**
     * Inner class representing a repair task.
     */
    public static class RepairTask {
        private TwoWheeledVehicle vehicle;
        private String startDateTime;
        private String endDateTime;

        /**
         * Constructor of the class
         * @param vehicle
         * @param startDateTime
         * @param endDateTime
         */
        public RepairTask(TwoWheeledVehicle vehicle, String startDateTime, String endDateTime) {
            this.vehicle = vehicle;
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
        }

        /**
         * @return the vehicle
         */
        public TwoWheeledVehicle getVehicle() {
            return vehicle;
        }

        /**
         * @return the start date time
         */
        public String getStartDateTime() {
            return startDateTime;
        }

        /**
         * @return the end date time
         */
        public String getEndDateTime() {
            return endDateTime;
        }
    }
}
