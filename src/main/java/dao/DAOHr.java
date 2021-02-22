package dao;

import entity.Employer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOHr implements DAO<Employer> {


    private final ArrayList<Employer> employersAll = new ArrayList<>();

    public DAOHr() throws IOException {
        read();
    }

    @Override
    public Optional<Employer> get(int id) {
        return Optional.of(employersAll.get(id));
    }

    @Override
    public List<Employer> getAllBy(Predicate<Employer> p) {
        return employersAll.stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Employer employer) {
        employersAll.add(employer);
    }

    @Override
    public List<Employer> getAll() {
        return employersAll;
    }

    @Override
    public void delete(Employer employer) {

    }


    public void write() throws IOException {
        File employers = new File("Employers.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(employers));
        String line;
        for (int i = 0; i < employersAll.size(); i++) {

        }
        for (Employer employer : employersAll) {
            line = String.format("%d, %s, %s, %s, %s, %s, %d.\n",
                    employer.getId(), employer.getLogin(), employer.getPassword(), employer.getName(),
                    employer.getSurname(), employer.getDepartment(), employer.getExperience());
            bw.write(line);
            bw.write("\n");
        }
        bw.close();
    }

    private void read() throws IOException {
        File employers = new File("Employers.txt");
//        employers.createNewFile();
        BufferedReader reader = new BufferedReader(new FileReader(employers));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] info = line.trim().split("\\.");
            String[] employerInfo = info[0].trim().split(",");
            for (Employer employer : employersAll) {
                employersAll.add(new Employer(Integer.parseInt(employerInfo[0]), employerInfo[1],
                        employerInfo[2], employerInfo[3], employerInfo[4], employerInfo[5],
                        Integer.parseInt(employerInfo[6]), employerInfo[7]));
            }
        }
    }
}
