package com.esprit.microservice.candidat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatService {
private final CandidatRepository candidatRepository;
public List<Candidat> getAllCandidats(){
    return candidatRepository.findAll();
}
public Candidat getCandidatById(int id ){
    return candidatRepository.findById(id).orElse(null);
}
    public Candidat addCandidat(Candidat candidate) {
        return candidatRepository.save(candidate);
    }
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidatRepository.findById(id).isPresent()) {
            Candidat existingCandidat = candidatRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidatRepository.save(existingCandidat);
        } else
            return null;
    }

    public String deleteCandidat(int id) {
        if (candidatRepository.findById(id).isPresent()) {
            candidatRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }

}
