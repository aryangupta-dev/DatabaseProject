/*   Created by IntelliJ IDEA.
 *   Author: Aryan gupta (ag2602)
 *   Date: 11/20/2020
 *   Time: 12:24 PM
 *   File: City.java
 */

package Data;

import java.util.Objects;

    public class City {
        private String name;
        private boolean traversed;
        private int kilometres;

        public City(String name,boolean traversed,int kilometres){
            this.name=name;
            this.traversed=traversed;
            this.kilometres=kilometres;
        }
        public String getName(){
            return name;
        }

        public int getKilometres() {
            return kilometres;
        }

        public boolean isTraversed() {
            return traversed;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setKilometres(int kilometres) {
            this.kilometres = kilometres;
        }

        public void setTraversed(boolean traversed) {
            this.traversed = traversed;
        }

        @Override
        public String toString() {
            return
                    (isTraversed() ? "I have visited " : "I haven't visited ") + getName() + " it is " + getKilometres() + "km away";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data.City city = (Data.City) o;
            return traversed == city.traversed &&
                    kilometres == city.kilometres &&
                    Objects.equals(name, city.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, traversed, kilometres);
        }
    }